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

 Date: 10/09/2021 11:49:16
*/


-- ----------------------------
-- Table structure for cargos
-- ----------------------------
DROP TABLE IF EXISTS "public"."cargos";
CREATE TABLE "public"."cargos" (
  "id" int8 NOT NULL DEFAULT nextval('cargos_id_seq'::regclass),
  "nombre" varchar(255) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Primary Key structure for table cargos
-- ----------------------------
ALTER TABLE "public"."cargos" ADD CONSTRAINT "cargos_pkey" PRIMARY KEY ("id");
