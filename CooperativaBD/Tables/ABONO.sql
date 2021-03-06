USE [CooperativaBD]
GO

/****** Object:  Table [dbo].[ABONO]    Script Date: 22/09/2017 10:57:09 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[ABONO](
	[CODIGO_ABONO] [nvarchar](30) NOT NULL,
	[NUMERO_CUENTA] [nvarchar](20) NOT NULL,
	[MONTO_ABONO] [decimal](10, 2) NULL,
	[FECHA_ABONO] [date] NULL,
	[COMENTARIO] [varchar](100) NULL,
	[FECHA_CREACION] [datetime] NULL,
	[FECHA_MODIF] [datetime] NULL,
	[CREADO_POR] [nvarchar](50) NULL,
	[MODIFICADO_POR] [nvarchar](50) NULL,
 CONSTRAINT [PK_ABONO] PRIMARY KEY CLUSTERED 
(
	[CODIGO_ABONO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO


