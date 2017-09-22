USE [CooperativaBD]
GO

/****** Object:  StoredProcedure [dbo].[SP_EMPLEADO_GET_NOMBRE_COMPLETO]    Script Date: 22/09/2017 13:36:21 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SP_EMPLEADO_GET_NOMBRE_COMPLETO] 
	-- Add the parameters for the stored procedure here
	@CODIGO_EMPLEADO BIGINT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT CODIGO_EMPLEADO, PRIMER_NOMBRE, SEGUNDO_NOMBRE, PRIMER_APELLIDO, SEGUNDO_APELLIDO FROM EMPLEADO
		WHERE CODIGO_EMPLEADO = @CODIGO_EMPLEADO
END
GO


