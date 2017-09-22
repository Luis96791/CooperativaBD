USE [CooperativaBD]
GO

/****** Object:  StoredProcedure [dbo].[SP_PRESTAMO_UPDATE]    Script Date: 22/09/2017 13:39:06 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SP_PRESTAMO_UPDATE]
	-- Add the parameters for the stored procedure here
	@NUMERO_PRESTAMO NVARCHAR(30),
	@MODIF_POR NVARCHAR(30)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	UPDATE dbo.PRESTAMO SET SALDO_PRESTAMO = SALDO_PRESTAMO-CUOTA_MENSUAL, NUMERO_PERIODO = NUMERO_PERIODO+1,  FECHA_MODIF = GETDATE(), MODIFICADO_POR = @MODIF_POR
	WHERE @NUMERO_PRESTAMO = NUMERO_PRESTAMO
END
GO


