USE [CooperativaBD]
GO

/****** Object:  StoredProcedure [dbo].[SP_CUENTAS_UPDATE_ANTIGUEDAD]    Script Date: 22/09/2017 13:35:08 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SP_CUENTAS_UPDATE_ANTIGUEDAD]
	-- Add the parameters for the stored procedure here
	
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	UPDATE CUENTA SET ANTIGUEDAD = DATEDIFF(DAY, FECHA_APERTURA, SYSDATETIME())
END
GO


