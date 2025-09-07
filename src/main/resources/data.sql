INSERT INTO address (cep, street, complement, unit, district, city, state_code, state) VALUES
('01001-000', 'Praça da Sé', 'lado ímpar', '', 'Sé', 'São Paulo', 'SP', 'São Paulo'),
('20010-010', 'Praça Quinze de Novembro', '', '', 'Centro', 'Rio de Janeiro', 'RJ', 'Rio de Janeiro'),
('30130-050', 'Avenida Afonso Pena', '', '', 'Boa Viagem', 'Belo Horizonte', 'MG', 'Minas Gerais'),
('40010-010', 'Rua Chile', '', '', 'Centro', 'Salvador', 'BA', 'Bahia'),
('50010-100', 'Rua do Bom Jesus', '', '', 'Recife', 'Recife', 'PE', 'Pernambuco');

INSERT INTO users (email, name, address_id) VALUES
('joao.silva@exemplo.com', 'João Silva', 1),
('maria.souza@exemplo.com', 'Maria Souza', 2),
('carlos.oliveira@exemplo.com', 'Carlos Oliveira', 3),
('ana.santos@exemplo.com', 'Ana Santos', 4),
('paulo.costa@exemplo.com', 'Paulo Costa', 5);