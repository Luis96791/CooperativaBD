USE [CooperativaBD]
GO

/****** Object:  Table [dbo].[CUENTA]    Script Date: 22/09/2017 10:58:37 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[CUENTA](
	[NUMERO_CUENTA] [nvarchar](20) NOT NULL,
	[CODIGO_EMPLEADO] [bigint] NULL,
	[TIPO_CUENTA] [nvarchar](50) NULL,
	[FECHA_APERTURA] [date] NULL,
	[AHORRO_MENSUAL] [decimal](10, 2) NULL,
	[ANTIGUEDAD] [int] NULL,
	[SALDO_CUENTA] [decimal](10, 2) NULL,
	[FECHA_CREACION] [datetime] NULL,
	[FECHA_MODIF] [datetime] NULL,
	[CREADO_POR] [nvarchar](50) NULL,
	[MODIFICADO_POR] [nvarchar](50) NULL,
 CONSTRAINT [PK_CUENTA] PRIMARY KEY CLUSTERED 
(
	[NUMERO_CUENTA] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO


