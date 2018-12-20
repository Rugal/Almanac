--
-- PostgreSQL database dump
--


CREATE SCHEMA IF NOT EXISTS almanac;
SET search_path TO almanac;

CREATE TABLE category (
    cid serial PRIMARY KEY,
    name character varying(50),
    description character varying(100)
);

CREATE TABLE locale (
    lid serial PRIMARY KEY,
    language character varying(20),
    country character varying(20)
);

CREATE TABLE hexagram (
    hid serial PRIMARY KEY,
    cid integer REFERENCES category(cid),
    weekend boolean DEFAULT false
);

CREATE TABLE translation (
    tid serial PRIMARY KEY,
    hid integer REFERENCES hexagram(hid),
    lid integer REFERENCES locale(lid),
    is_title boolean,
    is_aspicious boolean,
    content character varying(100)
);

ALTER TABLE ONLY locale
    ADD CONSTRAINT locale_language_country_key UNIQUE (language, country);

CREATE INDEX hexagram_cid_index ON hexagram USING btree (cid);
CREATE INDEX translation_hid_index ON translation USING btree (hid);

--
-- PostgreSQL database dump complete
--

