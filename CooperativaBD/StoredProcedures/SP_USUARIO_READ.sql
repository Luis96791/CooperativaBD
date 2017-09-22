USE [CooperativaBD]
GO

/****** Object:  StoredProcedure [dbo].[SP_USUARIO_READ]    Script Date: 22/09/2017 13:40:36 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SP_USUARIO_READ] 
(
	@ID_USUARIO NVARCHAR(20)
)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;
	
	SELECT 
		u.ID_USUARIO, 
		u.CONTRASEÑA,
		r.TIPO_ROL,
		p.DESCRIPCION 
	FROM USUARIO u INNER JOIN ROL r ON r.ID_ROL = u.ID_ROL
	INNER JOIN PRIVILEGIO p ON p.ID_ROL = r.ID_ROL
	WHERE u.ID_USUARIO = @ID_USUARIO
	
    -- Insert statements for procedure here
END
GO


