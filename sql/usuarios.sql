/*
 Navicat Premium Data Transfer

 Source Server         : localpg12
 Source Server Type    : PostgreSQL
 Source Server Version : 120008
 Source Host           : localhost:5433
 Source Catalog        : inventario_nexos
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 120008
 File Encoding         : 65001

 Date: 10/09/2021 11:49:35
*/


-- ----------------------------
-- Table structure for usuarios
-- ----------------------------
DROP TABLE IF EXISTS "public"."usuarios";
CREATE TABLE "public"."usuarios" (
  "id" int8 NOT NULL DEFAULT nextval('usuarios_id_seq'::regclass),
  "edad" int4 NOT NULL,
  "fecha_ingreso" timestamp(6) NOT NULL,
  "nombre" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "cargo_id" int8 NOT NULL
)
;

-- ----------------------------
-- Primary Key structure for table usuarios
-- ----------------------------
ALTER TABLE "public"."usuarios" ADD CONSTRAINT "usuarios_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Keys structure for table usuarios
-- ----------------------------
ALTER TABLE "public"."usuarios" ADD CONSTRAINT "fk65oyat1njp8ljm3nof536upvj" FOREIGN KEY ("cargo_id") REFERENCES "public"."cargos" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
