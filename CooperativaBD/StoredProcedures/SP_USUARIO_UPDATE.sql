USE [CooperativaBD]
GO

/****** Object:  StoredProcedure [dbo].[SP_USUARIO_UPDATE]    Script Date: 22/09/2017 13:40:47 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SP_USUARIO_UPDATE]
(
	@ID_USUARIO NVARCHAR(20) OUT, @CODIGO_EMPLEADO BIGINT,
	@CONTRASEÑA NVARCHAR(20), @MODIF_POR NVARCHAR(20)
)
AS
	DECLARE
		@FECHA_MODIF DATETIME

	SET @FECHA_MODIF = GETDATE()
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	UPDATE DBO.USUARIO SET ID_USUARIO = @ID_USUARIO, CONTRASEÑA = @CONTRASEÑA, FECHA_MODIF = @FECHA_MODIF, MODIFICADO_POR = @MODIF_POR
	WHERE CODIGO_EMPLEADO = @CODIGO_EMPLEADO   
END
GO


