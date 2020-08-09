INSERT INTO stores_cordinates (store_id, store_name, location)
VALUES (uuid_generate_v4(),'Ataşehir MMM Migros',ST_MakePoint(29.1244229,40.9923307));

INSERT INTO stores_cordinates (store_id, store_name, location)
VALUES (uuid_generate_v4(),'Novada MMM Migros',ST_MakePoint(29.1161293,40.986106));

INSERT INTO stores_cordinates (store_id, store_name, location)
VALUES (uuid_generate_v4(),'Beylikdüzü 5M Migros',ST_MakePoint(28.6552262,41.0066851));

INSERT INTO stores_cordinates (store_id, store_name, location)
VALUES (uuid_generate_v4(),'Ortaköy MMM Migros',ST_MakePoint(29.0210292,41.055783));

INSERT INTO stores_cordinates (store_id, store_name, location)
VALUES (uuid_generate_v4(),'Caddebostan MMM Migros',ST_MakePoint(29.0630908,40.9632463));

INSERT INTO courier(courier_id, courier_name)
VALUES (1,'Ahmet Serdar Geze');



INSERT INTO courier_log (courier_log_id, courier_id,geom_location)
VALUES (uuid_generate_v4(),1,ST_MakePoint(29.1244229,40.9923307));


INSERT INTO courier_log (courier_log_id, courier_id,geom_location)
VALUES (uuid_generate_v4(),1,ST_MakePoint(29.1161293,40.986106));


INSERT INTO courier_log (courier_log_id, courier_id,geom_location)
VALUES (uuid_generate_v4(),1,ST_MakePoint(28.6552262,41.0066851));

INSERT INTO courier_log (courier_log_id, courier_id,geom_location)
VALUES (uuid_generate_v4(),1,ST_MakePoint(29.0210292,41.055783));


