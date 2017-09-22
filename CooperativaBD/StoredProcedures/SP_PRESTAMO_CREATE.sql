USE [CooperativaBD]
GO

/****** Object:  StoredProcedure [dbo].[SP_PRESTAMO_CREATE]    Script Date: 22/09/2017 13:38:30 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SP_PRESTAMO_CREATE] 
	-- Add the parameters for the stored procedure here
(
	@CODIGO_EMPLEADO BIGINT, @MONTO_PRESTAMO DECIMAL(10,2),
	@PERIODOS_PRESTAMO INT, @CREADO_POR NVARCHAR(50), @STATUS INT OUT
)
AS
	DECLARE
		@VAR_NUMERO_PRESTAMO NVARCHAR(20), --NUMERO DEL PRESTAMO LLAMA UN PROCEDURE
		@VAR_BUSCAR_ID_EMPLEADO BIGINT,	--BUSCA EL ID_EMPLEADO EN LA TABLA PRESTAMOS, PARA VALIDAR QUE NO TENGA PRESTAMOS
		@VAR_SALDO_CUENTA_APORTACION DECIMAL(10,2),	--OBTIENE EL SALDO DE LA CUENTA QUE SEA DE APORTACIONES
		@VAR_TIPO_PRESTAMO NVARCHAR(30),	-- SOLO SE SETEA A AUTOMATICO O FIDUCIARIO
		@VAR_TASA_INTERES DECIMAL(10,2),	--CONSULTA LA TASA CORRESPONDIENTE EN LA TABLA INFO_PRESTAMO
		@VAR_SALDO_PRESTAMO DECIMAL(10,2),	--SUMA EL MONTO_PRESTAMO + EL INTERES DEL MISMO
		@VAR_CUOTA_MENSUAL DECIMAL(10,2)	--LLAMA LA FUNCION PMT QUE ASIGNA LA PRIMERA CUOTA MENSUAL
BEGIN
	SET @VAR_BUSCAR_ID_EMPLEADO = (SELECT CODIGO_EMPLEADO FROM PRESTAMO
									WHERE CODIGO_EMPLEADO = @CODIGO_EMPLEADO)

	SET @VAR_SALDO_CUENTA_APORTACION = (SELECT SALDO_CUENTA FROM CUENTA
										WHERE CODIGO_EMPLEADO = @CODIGO_EMPLEADO AND TIPO_CUENTA = 'APORTACION')

	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;
	SET @STATUS = 0

	IF(@PERIODOS_PRESTAMO > 12 OR @PERIODOS_PRESTAMO < 1)
	BEGIN
		SET @STATUS = 1 --MAYOR A 12 MESES
	END

	IF(@VAR_BUSCAR_ID_EMPLEADO != 0)
	BEGIN
		SET @STATUS = 2 --YA EXISTE UN PRESTAMO PARA ESTE EMPLEADO
	END

	IF(@VAR_SALDO_CUENTA_APORTACION  < (SELECT MONTO_MAXIMO FROM INFO_PRESTAMO WHERE TIPO_PRESTAMO = 'FIDUCIARIO'))
	BEGIN
		SET @VAR_TASA_INTERES = (SELECT TASA_INTERES FROM INFO_PRESTAMO WHERE TIPO_PRESTAMO = 'FIDUCIARIO')
		IF(@MONTO_PRESTAMO > (SELECT MONTO_MAXIMO FROM INFO_PRESTAMO WHERE TIPO_PRESTAMO = 'FIDUCIARIO'))
		BEGIN
			SET @MONTO_PRESTAMO = (SELECT MONTO_MAXIMO FROM INFO_PRESTAMO WHERE TIPO_PRESTAMO = 'FIDUCIARIO')
		END
		SET @VAR_TIPO_PRESTAMO = 'FIDUCIARIO'
	END

	IF(@MONTO_PRESTAMO  > (SELECT MONTO_MAXIMO FROM INFO_PRESTAMO WHERE TIPO_PRESTAMO = 'FIDUCIARIO')
		AND @MONTO_PRESTAMO <= @VAR_SALDO_CUENTA_APORTACION)
	BEGIN
		SET @VAR_TASA_INTERES = (SELECT TASA_INTERES FROM INFO_PRESTAMO WHERE TIPO_PRESTAMO = 'AUTOMATICO')
		SET @VAR_TIPO_PRESTAMO = 'AUTOMATICO'
	END

	
	
	IF(@STATUS = 0)--TODO BIEN
	BEGIN
		SET @VAR_NUMERO_PRESTAMO = 'PST-'+CAST(NEXT VALUE FOR SQ_PRESTAMO_NUMERO_PRESTAMO AS NVARCHAR)
		EXEC @VAR_CUOTA_MENSUAL = dbo.FN_PRESTAMO_PMT @VAR_TASA_INTERES, @PERIODOS_PRESTAMO, @MONTO_PRESTAMO, 0, 0
		SET @VAR_SALDO_PRESTAMO = @VAR_CUOTA_MENSUAL * @PERIODOS_PRESTAMO
		
		INSERT INTO PRESTAMO(NUMERO_PRESTAMO, CODIGO_EMPLEADO, FECHA_PRESTAMO, TIPO_PRESTAMO, MONTO_PRESTAMO,
		PERIODOS_PRESTAMO, NUMERO_PERIODO, CUOTA_MENSUAL, SALDO_PRESTAMO, FECHA_CREACION, CREADO_POR)
		VALUES(@VAR_NUMERO_PRESTAMO, @CODIGO_EMPLEADO, SYSDATETIME(), @VAR_TIPO_PRESTAMO, @MONTO_PRESTAMO, 
		@PERIODOS_PRESTAMO, 1, @VAR_CUOTA_MENSUAL, @VAR_SALDO_PRESTAMO, GETDATE(), @CREADO_POR)
	END
		
    -- Insert statements for procedure here
	
END
GO


