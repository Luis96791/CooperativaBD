USE [CooperativaBD]
GO

/****** Object:  StoredProcedure [dbo].[SP_EMPLEADO_READ]    Script Date: 22/09/2017 13:36:40 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SP_EMPLEADO_READ] 
	-- Add the parameters for the stored procedure here
	@CODIGO_EMPLEADO BIGINT
AS
	--DECLARE CURSOR_EMPLEADO_READ CURSOR FOR  
	
	--OPEN CURSOR_EMPLEADO_READ
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

	SELECT CODIGO_EMPLEADO, CALLE, AVENIDA, NUMERO_CASA, CIUDAD, DEPARTAMENTO FROM EMPLEADO
							WHERE @CODIGO_EMPLEADO = CODIGO_EMPLEADO
    -- Insert statements for procedure here
	--FETCH NEXT FROM CURSOR_EMPLEADO_READ
END
GO


