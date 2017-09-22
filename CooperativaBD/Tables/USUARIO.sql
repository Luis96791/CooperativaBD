USE [CooperativaBD]
GO

/****** Object:  Table [dbo].[USUARIO]    Script Date: 22/09/2017 11:03:12 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[USUARIO](
	[ID_USUARIO] [nvarchar](20) NOT NULL,
	[CODIGO_EMPLEADO] [bigint] NULL,
	[CONTRASE�A] [nvarchar](20) NULL,
	[ID_ROL] [nvarchar](20) NOT NULL,
	[FECHA_CREACION] [datetime] NULL,
	[FECHA_MODIF] [datetime] NULL,
	[CREADO_POR] [nvarchar](50) NULL,
	[MODIFICADO_POR] [nvarchar](50) NULL,
 CONSTRAINT [PK_USUARIO] PRIMARY KEY CLUSTERED 
(
	[ID_USUARIO] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

