USE [CooperativaBD]
GO

/****** Object:  StoredProcedure [dbo].[SP_CUENTA_READ]    Script Date: 22/09/2017 13:34:36 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SP_CUENTA_READ] 
	-- Add the parameters for the stored procedure here
	@CODIGO_EMPLEADO BIGINT,
	@TIPO_CUENTA NVARCHAR(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT CODIGO_EMPLEADO, TIPO_CUENTA, NUMERO_CUENTA, FECHA_APERTURA, AHORRO_MENSUAL, ANTIGUEDAD, SALDO_CUENTA
	FROM CUENTA WHERE CODIGO_EMPLEADO = @CODIGO_EMPLEADO AND TIPO_CUENTA = @TIPO_CUENTA
END
GO


