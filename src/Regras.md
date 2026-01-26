Boa. Agora sim você está pedindo algo que vale a pena 😈
Vou te dar um desafio **mais complexo**, mas ainda realista — e que força POO de verdade, não só classe + getter/setter.

---

# 🧠 DESAFIO JAVA – NÍVEL INTERMEDIÁRIO (POO REAL)

## 🎯 Tema: Sistema de Gerenciamento de Pedidos (Mini E-commerce)

Você vai criar um sistema que simula pedidos de uma loja online.

---

## 🧱 Requisitos mínimos (obrigatórios)

### 1) Classe `Produto`

Atributos:

* id (int)
* nome (String)
* preco (BigDecimal ou double — escolha consciente 👀)
* estoque (int)

Regras:

* Não pode vender produto sem estoque
* Não pode ter estoque negativo

Métodos obrigatórios:

* reduzirEstoque(int quantidade)
* aumentarEstoque(int quantidade)

---

### 2) Classe `Cliente`

Atributos:

* id (int)
* nome (String)
* tipoCliente (NORMAL ou VIP)

Regra:

* Cliente VIP tem desconto de 10%

---

### 3) Classe `ItemPedido`

Atributos:

* produto (Produto)
* quantidade (int)

Regra:

* quantidade não pode ser <= 0
* subtotal = preco do produto * quantidade

Método:

* calcularSubtotal()

💡 Dica: essa classe é o coração do desafio.

---

### 4) Classe `Pedido`

Atributos:

* id (int)
* cliente (Cliente)
* lista de itens (List<ItemPedido>)
* status (CRIADO, PAGO, CANCELADO)

Regras:

#### ✅ Adicionar item:

* Não pode adicionar produto sem estoque
* Não pode adicionar o mesmo produto duas vezes (ou decide como tratar isso)

#### ✅ Calcular total:

* Soma dos subtotais
* Aplica desconto se cliente for VIP

#### ✅ Pagar pedido:

* Só pode pagar se status = CRIADO
* Ao pagar, reduz estoque dos produtos

#### ✅ Cancelar pedido:

* Só pode cancelar se status = CRIADO
* Se cancelar, nada de mexer no estoque

---

### 5) Classe `Sistema` (ou Main)

Você deve:

* criar produtos
* criar clientes
* criar pedidos
* adicionar itens
* pagar pedidos
* testar casos inválidos

---

# 💣 Regras que vão te forçar a pensar (importante)

## ❌ Proibido:

* acessar atributos diretamente
* lógica de negócio no `main`
* `public` em atributos
* ifs gigantes no `main`

## ✅ Obrigatório:

* objetos decidindo seu próprio comportamento
* métodos com responsabilidade clara
* estados protegidos (status do pedido, estoque do produto, etc.)

---

# 🧠 Nível extra (opcional, mas insano)

Se quiser deixar o desafio nível HARD:

* implemente rollback de estoque ao cancelar pedido pago
* implemente exceções personalizadas
* implemente relatório de vendas
* implemente limite de compra por cliente

---

# 🎯 Se você fizer esse desafio bem feito…

Você vai entender algo que 90% dos iniciantes não entendem:

👉 POO não é criar classes.
👉 POO é distribuir responsabilidades corretamente.

---

# 😈 Se você topar, me manda seu design antes do código.

Tipo:

* quais classes você vai criar
* quem vai ser responsável pelo quê

Se sua modelagem estiver errada, eu vou desmontar antes de você codar.
Isso acelera seu aprendizado absurdamente.
