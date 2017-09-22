USE [CooperativaBD]
GO

/****** Object:  StoredProcedure [dbo].[SP_CUENTA_UPDATE]    Script Date: 22/09/2017 13:34:54 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SP_CUENTA_UPDATE] 
	-- Add the parameters for the stored procedure here
	@NUMERO_CUENTA NVARCHAR(30),
	@MODIF_POR NVARCHAR(30)
	
AS
	DECLARE @VAR_SALDO_CUENTA DECIMAL(10,2)
BEGIN
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	UPDATE dbo.CUENTA SET ANTIGUEDAD = DATEDIFF(DAY, FECHA_APERTURA, SYSDATETIME()), SALDO_CUENTA = SALDO_CUENTA+AHORRO_MENSUAL, 
		FECHA_MODIF = GETDATE(), MODIFICADO_POR = @MODIF_POR
	WHERE @NUMERO_CUENTA = NUMERO_CUENTA
END
GO


