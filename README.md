# liare

TABLAS

------------------------------------------------------------------

  CREATE TABLE "SYSTEM"."USUARIO" 
   (	"C_PERL_CODIGO" NUMBER(*,0) NOT NULL ENABLE, 
	"N_MST_LOGIN" VARCHAR2(20 BYTE), 
	"N_MST_NOMBRE" VARCHAR2(20 BYTE), 
	"N_MST_APEPATERNO" VARCHAR2(20 BYTE), 
	"N_MST_APEMATERNO" VARCHAR2(20 BYTE), 
	"N_MST_EMAIL" VARCHAR2(50 BYTE), 
	"C_SIT_CODIGO" CHAR(1 BYTE), 
	"N_MST_PASSWORD" VARCHAR2(100 BYTE), 
	"C_UNO_CODIGO_OFICINA" VARCHAR2(20 BYTE), 
	"N_UNO_DESCRIPCION" VARCHAR2(20 BYTE), 
	"ID_ROL" NUMBER, 
	 CONSTRAINT "USUARIO_PK" PRIMARY KEY ("C_PERL_CODIGO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
  
  -- INSERTAR EN TABLA USUARIO
  --1	sconde	stevens	conde	meza	sconde@mininter.gob.pe	1	$2a$04$mSHGnGO9Z4LMuMcF9XvEsuGKROlul8rg7H1FHuqtEX4wjwzjImDBa	1	liare	1
  
  --USUARIO: sconde 
  -- pass: 1234
  
  
   CREATE TABLE "SYSTEM"."TB_ARCHIVO" 
   (	"IDARCHIVO" NUMBER(*,0) NOT NULL ENABLE, 
	"IDTIPORELACION" VARCHAR2(100 BYTE), 
	"IDRELACION" NUMBER(*,0), 
	"NOMBRE" VARCHAR2(100 BYTE), 
	"RUTAARCHIVO" VARCHAR2(200 BYTE), 
	"TIPOARCHIVO" NUMBER(*,0), 
	"EXTENSION" VARCHAR2(200 BYTE), 
	"TAMANO" NUMBER(*,0), 
	"ARCHIVO" BLOB, 
	"ESTADO" CHAR(1 BYTE), 
	 CONSTRAINT "TM_ARCHIVO_PK" PRIMARY KEY ("IDARCHIVO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE, 
	 CONSTRAINT "TB_ARCHIVO_FK1" FOREIGN KEY ("IDRELACION")
	  REFERENCES "SYSTEM"."CATEGORIA" ("ID_CATEGORIA") ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" 
 LOB ("ARCHIVO") STORE AS BASICFILE (
  TABLESPACE "SYSTEM" ENABLE STORAGE IN ROW CHUNK 8192 RETENTION 
  NOCACHE LOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)) ;
  
  
  
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  PAQUETE HEAD
  
  --------------------------------------------------------------------
  create or replace PACKAGE  PKG_BASE AS


TYPE RESULTADO_CURSOR IS REF CURSOR;




 PROCEDURE LOGIN_USUARIO(CCURSOR_RESULTADO  OUT RESULTADO_CURSOR, P_USERNAME IN VARCHAR2 );

 PROCEDURE ROLES_USUARIO(CCURSOR_RESULTADO OUT RESULTADO_CURSOR, P_CODUSUARIO IN NUMBER,P_COD_SISTEMA VARCHAR2 );

 PROCEDURE LISTARCATEGORIA(CCURSOR_RESULTADO OUT RESULTADO_CURSOR);

END PKG_BASE;

---------------------------------------------------------------------------

PAQUETE BODY
//////////////////////////////////////////////////////////


create or replace PACKAGE BODY pkg_base AS


        PROCEDURE login_usuario (
        ccursor_resultado   OUT                 resultado_cursor,
        p_username          IN                  VARCHAR2
    ) AS
    BEGIN
    -- TAREA: Se necesita implantacion para PROCEDURE PKG_BASE.LOGIN_USUARIO
        OPEN ccursor_resultado FOR SELECT
                                       a.c_perl_codigo,
                                       a.n_mst_login,
                                       a.n_mst_nombre,
                                       a.n_mst_apepaterno,
                                       a.n_mst_apematerno,
                                       a.n_mst_email,
                                       a.c_sit_codigo,
                                       a.n_mst_password,
                                       a.c_uno_codigo_oficina,
                                       a.n_uno_descripcion,
                                       a.c_sit_codigo,
                                       a.id_rol
                                   FROM
                                       usuario a
                                   WHERE
                                       upper(TRIM(a.n_mst_login)) = upper(TRIM(''
                                                                               || p_username
                                                                               || ''))
                                       AND a.c_sit_codigo = 1;

    END login_usuario;

    PROCEDURE ROLES_USUARIO (
        ccursor_resultado   OUT                 resultado_cursor,
        p_codusuario        IN                  NUMBER,
        p_cod_sistema       VARCHAR2
    ) AS
    BEGIN
        OPEN ccursor_resultado FOR SELECT
                                       ce.id_rol,
                                       ce.descripcion_rol,
                                       ce.alias_rol,
                                       su.n_mst_nombre,
                                       su.n_mst_apepaterno,
                                       su.n_mst_apematerno
                                   FROM
                                       rolesusuario ce
                                       INNER JOIN usuario su ON su.id_rol = ce.id_rol
                                   WHERE
                                       su.c_perl_codigo = p_codusuario;

    END roles_usuario;


PROCEDURE  LISTARCATEGORIA (  ccursor_resultado OUT   resultado_cursor    ) AS
    BEGIN
        OPEN ccursor_resultado FOR  select  
        ROWNUM AS items,cat.id_categoria, cat.nombre_categoria, ar.rutaarchivo, ar.idarchivo from categoria cat 
        inner join tb_archivo ar On cat.IDARCHIVO=ar.IDARCHIVO
        
 where cat.estado=1
 and
ar.idrelacion>1;

    END LISTARCATEGORIA;






END pkg_base;
