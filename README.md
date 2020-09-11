# reserva-de-hotel-exception1

Curso de Java Completo com o professor "Nelio Alves".
Acompanhe o problema de "Reserva de Hotel", onde estou aprendendo a tratar exceções(exception) em 3 niveis (acompanhe os commits) :
Solução 1 (Very bad solution) - Validei a Reserva na class principal (Program), tendo em vista que não pode. Poís, é um grande problema de delegação, ou seja, quem tem que validar a Reserva é a classe da própria Reserva(Reservation).
Solução 2 (Bad solution) - Deleguei a validação na classe Reserva(Reservation), tendo em vista que quando gerar um erro retornará string.
Solução 3 (Good solution) -  Validação da reserva com tratamento de exceções.
