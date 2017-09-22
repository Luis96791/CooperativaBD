USE [CooperativaBD]
GO

/****** Object:  UserDefinedFunction [dbo].[FN_GANANCIAS_ANIO_ACTUAL]    Script Date: 22/09/2017 13:30:38 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE FUNCTION [dbo].[FN_GANANCIAS_ANIO_ACTUAL]
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
	SELECT g.ID_GANANCIA, g.FECHA_REGISTRO, g.GANANCIA FROM USUARIO u 
		INNER JOIN EMPLEADO e ON u.CODIGO_EMPLEADO = e.CODIGO_EMPLEADO
		INNER JOIN GANANCIA g ON e.CODIGO_EMPLEADO = g.CODIGO_EMPLEADO
	WHERE u.ID_USUARIO = @ID_USUARIO AND g.FECHA_REGISTRO BETWEEN CAST(@FILTRO AS nvarchar)+'0101' AND CAST(@FILTRO AS nvarchar)+'1231'
)
GO


