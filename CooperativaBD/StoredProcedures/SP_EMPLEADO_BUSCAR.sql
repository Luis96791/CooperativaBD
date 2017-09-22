USE [CooperativaBD]
GO

/****** Object:  StoredProcedure [dbo].[SP_EMPLEADO_BUSCAR]    Script Date: 22/09/2017 13:35:24 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SP_EMPLEADO_BUSCAR] 
	-- Add the parameters for the stored procedure here
	@CODIGO_EMPLEADO BIGINT, 
		@RETURN_VALUE BIGINT OUT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
		SET @RETURN_VALUE = (SELECT CODIGO_EMPLEADO FROM EMPLEADO
		WHERE @CODIGO_EMPLEADO = CODIGO_EMPLEADO)
END
GO


