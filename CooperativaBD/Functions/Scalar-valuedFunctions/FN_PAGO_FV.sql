USE [CooperativaBD]
GO

/****** Object:  UserDefinedFunction [dbo].[FN_PAGO_FV]    Script Date: 22/09/2017 13:28:12 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date, ,>
-- Description:	<Description, ,>
-- =============================================
CREATE FUNCTION [dbo].[FN_PAGO_FV]
(
	-- Add the parameters for the function here
	@TASA DECIMAL(10,2),
	@NPER INT,
	@C INT,
	@PV DECIMAL(10,2),
	@TYPE INT
)
RETURNS DECIMAL(10,2)
AS
BEGIN
	-- Declare the return variable here
	DECLARE 
		@FV DECIMAL(10,2)

		IF @TYPE = 1
			SET @C = @C * (1 + (@TASA/12))
	-- Add the T-SQL statements to compute the return value here
	SET @FV  = (@C * (POWER(1 + (@TASA/12), @NPER) - 1) / (@TASA/12) + @PV  
    * POWER(1 + (@TASA/12), @NPER))
	-- Return the result of the function
	RETURN @FV

END
GO


