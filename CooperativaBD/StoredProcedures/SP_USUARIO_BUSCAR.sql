USE [CooperativaBD]
GO

/****** Object:  StoredProcedure [dbo].[SP_USUARIO_BUSCAR]    Script Date: 22/09/2017 13:39:29 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SP_USUARIO_BUSCAR]
	-- Add the parameters for the stored procedure here
	@ID_USUARIO NVARCHAR(20),
	@STATUS NVARCHAR(20) OUT
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SET @STATUS =  (SELECT ID_USUARIO FROM USUARIO WHERE @ID_USUARIO = ID_USUARIO)
END
GO


