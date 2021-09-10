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

 Date: 10/09/2021 11:49:26
*/


-- ----------------------------
-- Table structure for mercancias
-- ----------------------------
DROP TABLE IF EXISTS "public"."mercancias";
CREATE TABLE "public"."mercancias" (
  "id" int8 NOT NULL DEFAULT nextval('mercancias_id_seq'::regclass),
  "cantidad" int4 NOT NULL,
  "fecha_ingreso" timestamp(6) NOT NULL,
  "nombre" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "write_date" timestamp(6),
  "create_uid" int8 NOT NULL,
  "write_uid" int8
)
;

-- ----------------------------
-- Uniques structure for table mercancias
-- ----------------------------
ALTER TABLE "public"."mercancias" ADD CONSTRAINT "uk_4kr2pwxe1xo0hhp7akfxcccfq" UNIQUE ("nombre");

-- ----------------------------
-- Primary Key structure for table mercancias
-- ----------------------------
ALTER TABLE "public"."mercancias" ADD CONSTRAINT "mercancias_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Keys structure for table mercancias
-- ----------------------------
ALTER TABLE "public"."mercancias" ADD CONSTRAINT "fk6k56dvfh8kn3dfify5xx5n15i" FOREIGN KEY ("create_uid") REFERENCES "public"."usuarios" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."mercancias" ADD CONSTRAINT "fkg88dpey86qvtqic6704ixu2t5" FOREIGN KEY ("write_uid") REFERENCES "public"."usuarios" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
