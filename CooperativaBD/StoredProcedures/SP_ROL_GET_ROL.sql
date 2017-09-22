USE [CooperativaBD]
GO

/****** Object:  StoredProcedure [dbo].[SP_ROL_GET_ROL]    Script Date: 22/09/2017 13:39:17 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SP_ROL_GET_ROL] 
	-- Add the parameters for the stored procedure here
	@ID_USUARIO NVARCHAR(20),
	@GET_ROL NVARCHAR(20) OUT
AS	
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SET @GET_ROL = cast((SELECT 
		r.TIPO_ROL 
	FROM ROL r 
		INNER JOIN USUARIO u ON r.ID_ROL = u.ID_ROL
	WHERE u.ID_USUARIO = @ID_USUARIO)as nvarchar)
END
GO


