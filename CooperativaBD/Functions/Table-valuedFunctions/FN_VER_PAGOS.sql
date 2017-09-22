USE [CooperativaBD]
GO

/****** Object:  UserDefinedFunction [dbo].[FN_VER_PAGOS]    Script Date: 22/09/2017 13:31:58 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE FUNCTION [dbo].[FN_VER_PAGOS]
(	
	-- Add the parameters for the function here
	@NUMERO_PRESTAMO NVARCHAR(20)
)
RETURNS TABLE 
AS
RETURN 
(
	-- Add the SELECT statement with parameter references here
	SELECT NUMERO_PAGO, FECHA_PAGO, CAPITAL_PAGADO, INTERES_PAGADO FROM PAGO
	WHERE @NUMERO_PRESTAMO = NUMERO_PRESTAMO
)
GO


