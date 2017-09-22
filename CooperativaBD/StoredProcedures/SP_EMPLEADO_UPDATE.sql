USE [CooperativaBD]
GO

/****** Object:  StoredProcedure [dbo].[SP_EMPLEADO_UPDATE]    Script Date: 22/09/2017 13:36:54 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SP_EMPLEADO_UPDATE] 
	-- Add the parameters for the stored procedure here
	@CODIGO_EMPLEADO BIGINT,
	@CALLE NVARCHAR(20), @AVENIDA NVARCHAR(20), @NUMERO_CASA NVARCHAR(5),
	@CIUDAD NVARCHAR(20), @DEPARTAMENTO NVARCHAR(20), @MODIF_POR NVARCHAR(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	UPDATE DBO.EMPLEADO SET CALLE = @CALLE, AVENIDA = @AVENIDA, NUMERO_CASA = @NUMERO_CASA, CIUDAD = @CIUDAD, DEPARTAMENTO = @DEPARTAMENTO,
	FECHA_MODIF = GETDATE(), MODIFICADO_POR = @MODIF_POR
	WHERE @CODIGO_EMPLEADO = CODIGO_EMPLEADO
END
GO


