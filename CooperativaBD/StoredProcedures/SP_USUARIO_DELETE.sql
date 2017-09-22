USE [CooperativaBD]
GO

/****** Object:  StoredProcedure [dbo].[SP_USUARIO_DELETE]    Script Date: 22/09/2017 13:40:01 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SP_USUARIO_DELETE]
(
	@ID_USUARIO NVARCHAR(20)
)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	DELETE FROM DBO.USUARIO
	WHERE ID_USUARIO = @ID_USUARIO   
END
GO


