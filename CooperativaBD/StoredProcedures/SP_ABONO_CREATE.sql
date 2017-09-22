USE [CooperativaBD]
GO

/****** Object:  StoredProcedure [dbo].[SP_ABONO_CREATE]    Script Date: 22/09/2017 13:33:11 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SP_ABONO_CREATE] 
(
	@NUMERO_CUENTA NVARCHAR(30), @MONTO_ABONO DECIMAL(10,2), @CREADO_POR NVARCHAR(50)
)
AS
	DECLARE 
		@VAR_CODIGO_ABONO NVARCHAR(30)
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

	SET @VAR_CODIGO_ABONO = CAST(YEAR(GETDATE())AS nvarchar)+'-'+CAST(MONTH(GETDATE())AS NVARCHAR)+'-'+@NUMERO_CUENTA

	INSERT INTO ABONO(CODIGO_ABONO, NUMERO_CUENTA, MONTO_ABONO, FECHA_ABONO, FECHA_CREACION, CREADO_POR)
	VALUES(@VAR_CODIGO_ABONO, @NUMERO_CUENTA, @MONTO_ABONO, SYSDATETIME(), GETDATE(), @CREADO_POR)
    -- Insert statements for procedure here

END

GO


