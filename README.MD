# Refatoração do Módulo de Pedidos – Relatório Técnico

## 1. Análise Crítica do Código Legado

O código original apresentava problemas graves:

- **Ausência de encapsulamento** — atributos públicos expõem dados internos.
- **Baixa coesão** — uma única classe faz tudo: cálculo, resumo, etiqueta, promoções.
- **Acoplamento entre lógica e apresentação** — métodos `gerarEtiqueta()` e `gerarResumo()` produzem strings diretamente.
- **Valores mágicos** — coeficientes de frete espalhados no código.
- **Duplicação de lógica** (chamadas repetidas a `calcularFrete()`).
- **Falta de validações** — aceita peso negativo, campos vazios.
- **If-else encadeados** — viola o princípio Aberto–Fechado.
- **Maior risco de bugs** — código fica mais difícil de expandir.

---

## 2. Arquitetura Aplicada

### Camadas Criadas

- **domain**  
  Entidades centrais do negócio (`Entrega`, enums, exceções).

- **frete**  
  Estratégias concretas de cálculo (`FreteExpresso`, etc.).

- **service**  
  Serviços de aplicação (`EtiquetaService`, `FreteFactory`).

### Benefícios

- Separação clara de responsabilidades.
- Possibilidade de testes unitários isolados.
- Redução radical do acoplamento.
- Expansão simples: adicionar novo frete = criar nova classe.

---

## 3. Contratos e Validações

- `Entrega` é **imutável**, garantindo integridade.
- Validações no construtor bloqueiam estados inválidos.
- Exceções personalizadas tornam erros explícitos.
- Cálculo não acontece dentro do objeto e isso evita efeitos colaterais.

Isso garante robustez e previsibilidade do sistema.

---

## 4. Boas Práticas Adotadas

- **Nomeação semântica**: `Entrega`, `CalculadoraFrete`, `EtiquetaService`.
- **Pacotes coesos**: `domain`, `frete`, `service`.
- **Eliminação de comentários desnecessários** — o código explica sua intenção.
- **Strings multiline (Java 17)** tornam a formatação mais clara.

Essa organização facilita entender o fluxo mesmo sem documentação adicional.

---

## 5. Extensibilidade

Graças ao uso de **Strategy + Factory + Imutabilidade**:

- Adicionar novos fretes não exige mudar código existente.
- Etiquetas podem ter novos formatos criando novos serviços.
- Promoções podem ser adicionadas sem tocar no domínio.

O sistema agora segue as boas práticas do Clean Code e SOLID.

---

