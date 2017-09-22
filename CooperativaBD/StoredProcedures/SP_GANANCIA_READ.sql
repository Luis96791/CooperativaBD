USE [CooperativaBD]
GO

/****** Object:  StoredProcedure [dbo].[SP_GANANCIA_READ]    Script Date: 22/09/2017 13:37:36 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SP_GANANCIA_READ] 
	-- Add the parameters for the stored procedure here
	@CODIGO_EMPLEADO BIGINT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT ID_GANANCIA, FECHA_REGISTRO, GANANCIA FROM GANANCIA
		WHERE @CODIGO_EMPLEADO = CODIGO_EMPLEADO
END
GO


