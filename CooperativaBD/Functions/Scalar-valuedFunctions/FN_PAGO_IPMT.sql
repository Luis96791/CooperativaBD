USE [CooperativaBD]
GO

/****** Object:  UserDefinedFunction [dbo].[FN_PAGO_IPMT]    Script Date: 22/09/2017 13:28:46 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date, ,>
-- Description:	<Description, ,>
-- =============================================
CREATE FUNCTION [dbo].[FN_PAGO_IPMT]
(
	-- Add the parameters for the function here
	@TASA DECIMAL (10,2),
	@PER INT,
	@NPER INT,
	@PV DECIMAL (10,2),
	@FV DECIMAL (10,2),
	@TYPE INT
)
RETURNS DECIMAL (10,2)
AS
BEGIN
	-- Declare the return variable here
	DECLARE @IPMT DECIMAL(10,2)

	-- Add the T-SQL statements to compute the return value here
	SET  @IPMT = dbo.FN_PAGO_FV(@TASA, @PER-1, dbo.FN_PRESTAMO_PMT(@TASA, @NPER, @PV, @FV, @TYPE), @PV, @TYPE)* (@TASA/12)
	--dbo.Fv(@r, @per - 1, dbo.Pmt(@r, @nper, @pv, @fv, @type), @pv, @type) * @r 

	-- Return the result of the function
	RETURN @IPMT

END
GO


