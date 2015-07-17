BEGIN TRANSACTION;
CREATE TABLE `android_metadata` (
	`locale`	TEXT DEFAULT 'en-us'
);
INSERT INTO `android_metadata` (locale) VALUES ('en_US');
CREATE TABLE `Eventos` (
	`_id`	INTEGER,
	`nome`	TEXT,
	`data_escrita`	TEXT,
	`faixa_etaria`	TEXT,
	`local`	TEXT,
	`hora`	TEXT,
	`informacoes`	TEXT,
	`vagas`	TEXT,
	`valor`	TEXT,
	`categoria`	TEXT,
	`data`	TEXT
);
INSERT INTO `Eventos` (_id,nome,data_escrita,faixa_etaria,local,hora,informacoes,vagas,valor,categoria,data) VALUES (0,'luiz','carlos','amanha','opa','testando','eba','lol','aaa','sss','ss');
INSERT INTO `Eventos` (_id,nome,data_escrita,faixa_etaria,local,hora,informacoes,vagas,valor,categoria,data) VALUES (1,'niuu','kjji','jihih','ihihi','oihjihi','ihihi','ihihi','ojoj','ihih','ihih');
COMMIT;
