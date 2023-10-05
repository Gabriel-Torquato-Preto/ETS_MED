CREATE TABLE consultas(
id BIGINT AUTO_INCREMENT NOT NULL,
medico_id INTEGER NOT NULL,
paciente_id INTEGER NOT NULL,
data DATETIME NOT NULL,
PRIMARY KEY (id),
CONSTRAINT fk_consultas_medicos_id FOREIGN KEY (medico_id) REFERENCES medicos(id),
CONSTRAINT fk_consultas_paciente_id FOREIGN KEY (paciente_id) REFERENCES pacientes(id)
);