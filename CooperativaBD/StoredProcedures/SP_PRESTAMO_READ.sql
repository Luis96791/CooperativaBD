USE [CooperativaBD]
GO

/****** Object:  StoredProcedure [dbo].[SP_PRESTAMO_READ]    Script Date: 22/09/2017 13:38:52 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SP_PRESTAMO_READ] 
	-- Add the parameters for the stored procedure here
	@CODIGO_EMPLEADO BIGINT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here

	SELECT CODIGO_EMPLEADO, NUMERO_PRESTAMO,FECHA_PRESTAMO, TIPO_PRESTAMO, MONTO_PRESTAMO,
		PERIODOS_PRESTAMO, NUMERO_PERIODO, CUOTA_MENSUAL, SALDO_PRESTAMO
		FROM PRESTAMO
		WHERE CODIGO_EMPLEADO = @CODIGO_EMPLEADO
END
GO


