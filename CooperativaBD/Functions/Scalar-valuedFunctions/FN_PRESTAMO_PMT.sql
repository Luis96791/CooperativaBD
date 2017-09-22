USE [CooperativaBD]
GO

/****** Object:  UserDefinedFunction [dbo].[FN_PRESTAMO_PMT]    Script Date: 22/09/2017 13:29:24 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE FUNCTION [dbo].[FN_PRESTAMO_PMT] 
(
	-- Add the parameters for the function here
	@TASA DECIMAL(10,2), 
	@NPER INT, 
	@PV DECIMAL(10,2),
	@FV DECIMAL(10,2),
	@TYPE INT 
)
RETURNS DECIMAL(10,2)
AS
BEGIN
	-- Declare the return variable here
	DECLARE @RES DECIMAL(10,2)

	SET @RES = (@TASA/12) / (POWER(1.0 + (@TASA/12), @NPER) - 1.0)* (@PV * POWER(1.0 + (@TASA/12), @NPER)+ @FV)

	--SET @RES = (@pv*(@TASA/12))/(1-(1+(@TASA/12)power(@nper,-@nper)))

	IF @type = 1  
		SET @RES = @RES / (1 + (@TASA/12)) 
	
	RETURN @RES

END
GO


