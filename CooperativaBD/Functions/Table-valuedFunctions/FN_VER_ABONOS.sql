USE [CooperativaBD]
GO

/****** Object:  UserDefinedFunction [dbo].[FN_VER_ABONOS]    Script Date: 22/09/2017 13:31:37 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE FUNCTION [dbo].[FN_VER_ABONOS] 
(	
	-- Add the parameters for the function here
	@NUMERO_CUENTA NVARCHAR(20)
)
RETURNS TABLE 
AS
RETURN 
(
	-- Add the SELECT statement with parameter references here
	SELECT CODIGO_ABONO, MONTO_ABONO, FECHA_ABONO FROM ABONO 
	WHERE @NUMERO_CUENTA = NUMERO_CUENTA
)
GO


