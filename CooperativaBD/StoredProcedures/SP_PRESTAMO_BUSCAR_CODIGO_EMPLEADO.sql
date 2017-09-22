USE [CooperativaBD]
GO

/****** Object:  StoredProcedure [dbo].[SP_PRESTAMO_BUSCAR_CODIGO_EMPLEADO]    Script Date: 22/09/2017 13:38:03 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SP_PRESTAMO_BUSCAR_CODIGO_EMPLEADO] 
	-- Add the parameters for the stored procedure here
	@CODIGO_EMPLEADO BIGINT,
	@STATUS BIGINT OUT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SET @STATUS = (SELECT CODIGO_EMPLEADO FROM PRESTAMO WHERE CODIGO_EMPLEADO = @CODIGO_EMPLEADO)
END
GO


