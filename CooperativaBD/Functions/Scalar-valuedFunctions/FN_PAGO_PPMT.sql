USE [CooperativaBD]
GO

/****** Object:  UserDefinedFunction [dbo].[FN_PAGO_PPMT]    Script Date: 22/09/2017 13:29:05 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date, ,>
-- Description:	<Description, ,>
-- =============================================
CREATE FUNCTION [dbo].[FN_PAGO_PPMT] 
(
	-- Add the parameters for the function here
	@TASA DECIMAL(10,2),
	@PER INT,
	@NPER INT,
	@PV DECIMAL(10,2),
	@FV DECIMAL(10,2),
	@TYPE INT
)
RETURNS DECIMAL(10,2)
AS
BEGIN

	RETURN dbo.FN_PRESTAMO_PMT(@TASA, @NPER, @PV, @FV, @TYPE)-dbo.FN_PAGO_IPMT(@TASA, @PER, @NPER, @PV, @FV, @TYPE);

END
GO


