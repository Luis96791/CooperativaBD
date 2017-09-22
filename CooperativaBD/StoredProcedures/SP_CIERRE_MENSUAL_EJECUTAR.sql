USE [CooperativaBD]
GO

/****** Object:  StoredProcedure [dbo].[SP_CIERRE_MENSUAL_EJECUTAR]    Script Date: 22/09/2017 13:33:48 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SP_CIERRE_MENSUAL_EJECUTAR] 
	-- Add the parameters for the stored procedure here
	@MODIF_POR NVARCHAR(30),
	@STATUS INT OUT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	IF((SELECT EOMONTH(SYSDATETIME())) = SYSDATETIME())
	BEGIN
		SET @STATUS = 1
		EXEC SP_CIERRE_MENSUAL @MODIF_POR
	END
	ELSE
	BEGIN
		SET @STATUS = 0
	END
END
GO


