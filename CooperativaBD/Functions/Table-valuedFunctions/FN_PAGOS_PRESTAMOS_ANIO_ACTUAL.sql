USE [CooperativaBD]
GO

/****** Object:  UserDefinedFunction [dbo].[FN_PAGOS_PRESTAMOS_ANIO_ACTUAL]    Script Date: 22/09/2017 13:31:19 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE FUNCTION [dbo].[FN_PAGOS_PRESTAMOS_ANIO_ACTUAL]
(	
	-- Add the parameters for the function here
	@ID_USUARIO NVARCHAR(20),
	@FILTRO INT
)
RETURNS TABLE 
AS
RETURN 
(
	-- Add the SELECT statement with parameter references here
	SELECT pg.NUMERO_PAGO, pg.FECHA_PAGO, pg.CAPITAL_PAGADO, pg.INTERES_PAGADO FROM USUARIO u 
		INNER JOIN EMPLEADO e ON u.CODIGO_EMPLEADO = e.CODIGO_EMPLEADO
		INNER JOIN PRESTAMO p ON e.CODIGO_EMPLEADO = p.CODIGO_EMPLEADO
		INNER JOIN PAGO pg ON p.NUMERO_PRESTAMO = pg.NUMERO_PRESTAMO
	WHERE @ID_USUARIO = u.ID_USUARIO AND pg.FECHA_PAGO BETWEEN CAST(@FILTRO AS nvarchar)+'0101' AND CAST(@FILTRO AS nvarchar)+'1231'
)
GO


