# Projeto FiapRide - Leonardo Lopes Oliveira

## Informações do Aluno

- **Nome:** Leonardo Lopes Oliveira
- **RM:** [Seu RM]
- **Turma:** [Sua Turma]
- **Curso:** [Seu Curso]
- **GitHub:** [@Zinorblatant-cpu]

---

## Descrição do Projeto

Este projeto é o resultado do aprendizado nas aulas 1-9 de Programação Orientada a Objetos, onde desenvolvemos o sistema **FiapRide** (aplicativo de mobilidade urbana).

---

## Checklist de Implementação

- [x] Aula 1 - Classes e Objetos
- [x] Aula 2 - Métodos
- [x] Aula 3 - Encapsulamento
- [x] Aula 4 - Construtores
- [x] Aula 5 - Associação
- [x] Aula 6 - Herança
- [x] Aula 7 - Polimorfismo
- [x] Aula 8 - Classes Abstratas
- [x] Aula 9 - Interfaces

---

## Perguntas de Reflexão

### Aula 1 - Classes e Objetos

**Pergunta:** Por que precisamos criar uma classe `Passageiro`? Não seria mais fácil apenas criar variáveis soltas no main, como `String nomeAna = "Ana"` e `double saldoAna = 50.0`? E se o FiapRide tiver 1 milhão de usuários? Como a Classe ajuda a resolver isso?

**Sua Resposta:**
Criar variáveis soltas para cada usuário seria inviável com 1 milhão de passageiros — precisaríamos de 1 milhão de variáveis separadas para nome, saldo, email, etc. A classe `Passageiro` age como um molde: define uma vez a estrutura e permite criar quantos objetos quisermos com `new Passageiro()`. Cada objeto carrega seus próprios dados de forma organizada e coesa. Além disso, a classe agrupa comportamentos (métodos) junto aos dados, facilitando manutenção e evitando erros. Em escala de startup, sem classes, o código seria impossível de gerenciar.

---

### Aula 2 - Métodos

**Pergunta:** Se nós podemos simplesmente fazer `passageiro.saldo = passageiro.saldo + 100` diretamente no código principal, por que dá tanto trabalho criar um método específico chamado `adicionarSaldo(valor)` para fazer isso? Quais seriam os riscos para a nossa startup de mobilidade se deixássemos qualquer programador alterar o saldo diretamente?

**Sua Resposta:**
Alterar o saldo diretamente no main significa que qualquer programador pode colocar um valor negativo, zero ou inválido sem nenhum controle. O método `adicionarSaldo(valor)` centraliza a regra de negócio: só ele sabe como validar o valor, registrar a operação, e garantir que o saldo nunca fique inconsistente. Na nossa startup, isso é crítico — um bug que permite saldo negativo ou duplicação de crédito poderia gerar prejuízo financeiro real e perda de confiança dos usuários. Métodos criam um ponto único de controle sobre as mudanças de estado do objeto.

---

### Aula 3 - Encapsulamento

**Pergunta:** No nosso código, os atributos são `private`, mas os métodos `getSaldo()` e `getNome()` são `public`. Por que é seguro deixar o `get` público, mas perigoso deixar o atributo original público? Qual a diferença entre dar a alguém uma CÓPIA de um documento seu, e entregar o documento ORIGINAL para a pessoa rasurar?

**Sua Resposta:**
O `getSaldo()` retorna uma cópia do valor do saldo — quem recebe não tem como alterar o atributo original a partir disso. Se o atributo `saldo` fosse `public`, qualquer código externo poderia escrever `passageiro.saldo = -9999` sem passar por nenhuma validação. É exatamente a diferença da metáfora: entregar uma xerox protege o original. Com `private`, a classe controla completamente quem pode modificar seus dados e sob quais condições — esse é o núcleo do encapsulamento. O `get` expõe para leitura; o `set` com validação controla a escrita.

---

### Aula 4 - Construtores

**Pergunta:** Na nossa classe `Veiculo`, não criamos o `setModelo()` e o `setPlaca()` foi privado, com um método público `atualizarPlaca()`. Por que é um erro gravíssimo gerar Getters e Setters para tudo automaticamente? Como essas decisões protegem o sistema de fraudes?

**Sua Resposta:**
O modelo de um carro é imutável — um Civic não vira um Corolla. Gerar `setModelo()` automaticamente abriria a porta para alterar algo que não deveria mudar nunca, violando a realidade do domínio. Já a placa pode mudar (transferência de veículo), mas é um processo formal com regras. Por isso `setPlaca()` é privado e `atualizarPlaca()` público pode encapsular validações do formato da placa, logs de auditoria, etc. Gerar setters para tudo é perigoso porque transforma objetos em sacos de dados sem regras, facilitando fraudes como alterar placa de veículo clonado diretamente no objeto.

---

### Aula 5 - Associação

**Pergunta:** No construtor da `Viagem`, exigimos o objeto inteiro `Passageiro`. Se o resumo só precisa do nome, não seria mais leve pedir apenas a `String nomeDoPassageiro`? O que acontece quando a Viagem acaba e precisa descontar o saldo?

**Sua Resposta:**
Se a `Viagem` guardar apenas uma String com o nome, ela perdeu a referência para o objeto real. Quando a corrida terminar e o sistema precisar cobrar o valor, não há como chamar `passageiro.descontarSaldo(valor)` — a `Viagem` não sabe quem é o passageiro, só o nome dele. Com o objeto completo, a Viagem tem acesso a todos os comportamentos e dados do passageiro ao longo de todo o ciclo de vida da corrida. A associação TEM-UM vai além de armazenar dados: é manter a capacidade de interagir com o objeto associado quando as regras de negócio exigirem.

---

### Aula 6 - Herança

**Pergunta:** A mãe `Veiculo` tem `placa` e `modelo` como `private`. O `Carro` herda de `Veiculo` mas não consegue fazer `this.placa = "ABC"` diretamente. Por que o Java não deixa a filha alterar variáveis privadas da mãe? Qual princípio está sendo protegido?

**Sua Resposta:**
O encapsulamento não para na herança — ele continua protegendo os atributos privados mesmo das classes filhas. Se `Carro` pudesse escrever diretamente em `placa`, qualquer subclasse poderia contornar as validações definidas em `Veiculo`. O Java força o uso de `super()` ou `setPlaca()` justamente para garantir que as regras da classe mãe sejam sempre respeitadas. É o princípio do encapsulamento sendo aplicado na hierarquia: a filha herda o contrato público e protegido, mas não tem acesso privilegiado aos detalhes de implementação internos da mãe.

---

### Aula 7 - Polimorfismo

**Pergunta:** No loop `for (Veiculo veiculo : frota)`, se esquecêssemos de criar `calcularAutonomia()` na classe mãe `Veiculo`, conseguiríamos chamá-lo mesmo sabendo que existe em `Carro` e `Moto`? Por que o contrato precisa existir na base da hierarquia?

**Sua Resposta:**
Não conseguiríamos. A variável `veiculo` é do tipo `Veiculo` — o compilador só enxerga o que `Veiculo` declara. Mesmo que `Carro` e `Moto` tenham `calcularAutonomia()`, sem a declaração na mãe o compilador não tem como saber que todos os veículos da frota respondem a esse método. O contrato na base garante que, independente do tipo real do objeto em tempo de execução, a chamada é sempre válida. O polimorfismo depende dessa garantia estática: a mãe faz a promessa, as filhas cumprem com suas versões específicas.

---

### Aula 8 - Classes Abstratas

**Pergunta:** Faz sentido existir um objeto que é APENAS 'Veículo' sem ser um tipo específico? Por que precisamos dizer explicitamente ao Java que `Veiculo` é `abstract`? Qual o risco se esquecermos?

**Sua Resposta:**
Ninguém compra "um veículo" genérico — sempre é carro, moto, caminhão. O `abstract` instrui o compilador a proibir `new Veiculo()`, alinhando o código com a realidade do negócio. O Java não deduz isso sozinho porque a linguagem é explícita: sem `abstract`, a classe é considerada concreta e instanciável por padrão. O risco de esquecer é grave: alguém poderia criar `new Veiculo()` e adicionar esse objeto à frota — um veículo sem tipo definido, sem `calcularAutonomia()` implementado corretamente, quebrando a lógica de toda a aplicação. O `abstract` é a trava de segurança.

---

### Aula 9 - Interfaces

**Pergunta:** Por que Java permite herança simples mas múltipla implementação de interfaces? Se `CarroEletrico` herdasse de `Veiculo` E de `Bateria` e ambas tivessem `ligar()`, o que aconteceria? Como as interfaces resolvem isso?

**Sua Resposta:**
Com herança múltipla de classes, o compilador entraria no "problema do diamante": qual versão de `ligar()` o `CarroEletrico` deve usar — a de `Veiculo` ou a de `Bateria`? As duas têm implementação e estado, criando ambiguidade irresolvível. Interfaces resolvem isso porque definem apenas o contrato (assinatura do método), sem implementação ou estado próprio. Ao implementar múltiplas interfaces, a classe é obrigada a fornecer sua própria implementação de cada método — não há conflito porque não existe código da interface para herdar. É a separação entre "o que fazer" (interface) e "como fazer" (classe).

---

## Desafios Técnicos Implementados

### Desafio Pessoal (Seu Projeto)

**Qual foi o domínio que você escolheu para seu projeto pessoal?**
Sistema FiapRide - Aplicativo de mobilidade urbana

**Quais classes você criou?**
- `Passageiro` — representa o usuário do app
- `Veiculo` — classe abstrata base para os veículos
- `Carro` — veículo de 4 rodas com autonomia por litro
- `Moto` — veículo de 2 rodas com maior autonomia
- `Viagem` — associação entre passageiro e veículo
- `Rastreavel` — interface de contrato de rastreamento

**Qual foi o maior desafio técnico que você enfrentou?**
O maior desafio foi entender a transição da Aula 7 para a Aula 8: por que o polimorfismo funcionava com uma classe mãe concreta (Aula 7) e qual a diferença real ao torná-la abstrata (Aula 8). Na prática, o código parecia quase igual, mas o `abstract` mudava a intenção de design — impedia instâncias genéricas e forçava a implementação do método abstrato em todas as filhas. Resolver isso exigiu testar na prática o erro de compilação ao tentar `new Veiculo()` após torná-la abstrata, o que tornou o conceito concreto. A interface da Aula 9 também foi desafiadora por entender quando usar `interface` versus `abstract class` — a regra que ficou: `abstract class` para compartilhar código entre parentes, `interface` para definir contrato entre não-relacionados.

---

## Conclusão

**O que você aprendeu nestas 9 aulas?**
Aprendi que POO não é apenas sintaxe Java — é uma forma de modelar o mundo real no código. Cada aula revelou um problema diferente: organizar dados (classes), controlar comportamentos (métodos), proteger dados (encapsulamento), garantir inicialização correta (construtores), modelar relacionamentos (associação), reaproveitar código (herança), tratar objetos distintos de forma uniforme (polimorfismo), impor contratos de design (abstract), e separar contrato de implementação (interfaces).

**Qual conceito foi mais difícil de entender?**
Polimorfismo foi o mais desafiador — entender que a variável pode ser do tipo mãe mas o objeto em memória é da filha, e que o método chamado é o da filha em tempo de execução. Superei testando com `instanceof` e debugando o loop da frota passo a passo.

**O que você melhoraria no seu projeto se pudesse refazer?**
Criaria desde a Aula 1 pensando já na evolução para as aulas seguintes — por exemplo, já deixar espaço semântico para `private` mesmo antes da Aula 3, e nomear métodos pensando no contrato que viraria interface na Aula 9. Também adicionaria tratamento de exceções com `try-catch` nos setters para entradas inválidas.
