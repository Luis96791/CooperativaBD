USE [CooperativaBD]
GO

/****** Object:  UserDefinedFunction [dbo].[FN_ABONOS_APORTACIONES_ANIO_ACTUAL]    Script Date: 22/09/2017 13:30:20 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE FUNCTION [dbo].[FN_ABONOS_APORTACIONES_ANIO_ACTUAL] 
(	
	-- Add the parameters for the function here
	@ID_USUARIO NVARCHAR(20),
	@FILTRO INT
)
RETURNS TABLE 
AS
	
RETURN 
(
	SELECT a.CODIGO_ABONO, a.MONTO_ABONO, a.FECHA_ABONO FROM USUARIO u 
		INNER JOIN EMPLEADO e ON u.CODIGO_EMPLEADO = e.CODIGO_EMPLEADO
		INNER JOIN CUENTA c ON e.CODIGO_EMPLEADO = c.CODIGO_EMPLEADO
		INNER JOIN ABONO a ON c.NUMERO_CUENTA = a.NUMERO_CUENTA
	WHERE @ID_USUARIO = u.ID_USUARIO AND a.FECHA_ABONO BETWEEN CAST(@FILTRO AS nvarchar)+'0101' AND CAST(@FILTRO AS nvarchar)+'1231' 
			AND c.TIPO_CUENTA = 'APORTACION'
)
GO


