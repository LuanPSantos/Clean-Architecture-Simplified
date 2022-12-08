# Arquitetura Limpa Simplificada

#### Esse post é uma continuação direta desse outro post
[Do SOLID à Arquitetura Limpa](https://www.tabnews.com.br/TraineeCodeplays/do-solid-a-arquitetura-limpa)

Fala pessoal! Beleza?

Nesse post quero continuar no assunto de Arquitetura Limpa para apresentar uma variação mais simplificada dela. Essa abordagem é uma excelente substituda do modelo de três camadas que a gente costuma utilizar (Controller - Services - Repository).

PS: Esse post também é uma adaptação de um conteúdo que eu já tinha criado no meu [Github](https://github.com/LuanPSantos/Clean-Architecture-For-Spring-Application/blob/main/README.md) e que também é um vídeo no [Youtube](https://youtu.be/0bsCDQjTzA0).


![Diagrama Arquitetura Limpa](imgs/clean-arch.png)

Em resumo, a Arquitetura Limpa propõe mecanismos e ferramentas para que desenvolvedores construam softwares que sejam manutenível e expansíveis. Essa característica é alcançada ao tornar códigos de regra de negócio mais abstratos, com responsabilidades bem definidas e independentes de códigos de infraestrutura.

Alcançar o Estado da Arte da Arquitetura Limpa pode ser trabalhoso, algo caro para se construir e manter, e tem casos isso não vale a pena. Por isso, há um capítulo onde o autor fala sobre Limites Parciais, que explica que alguns limites arquiteturais podem ser quebrados dependendo da análise de quem está arquitetando o software. Ele pode decidir manter ou não algum limite arquitetural.

Atualmente, para a maioria dos projetos comerciais, é inviável construir um software sem utilizar algum framework. Eles resolvem muitos problemas comuns e aceleram o ciclo de desenvolvimento. Ao mesmo tempo, eles podem ser muito invasivos e acabar sujando o código, criando um acoplamento muito forte e o refém dele.

### Arquitetura Limpa e Framework

É muito comum, por exemplo, utilizar Spring Framework com Java/Kotlin para o desenvolvimento de aplicações comerciais. Ferramentas como Spring Boot, Spring MVC e Spring Data salvam a vida de muitos desenvolvedores todos os dias.

**Mas como ter uma Arquitetura Limpa trabalhando junto como o Framework?**

O diagrama a seguir mostra uma forma de conciliar o isolamento das regras de negócio, o core do software, e a utilização de frameworks para construir aplicações comerciais. A regra da dependência pode ser quebrada entre as camadas de frameworks (azul) e adapters (verde), pois nessas camadas não existirão códigos de negócios. Para as camadas de Use Case (vermelho) e Entity (amarelo), deve-se manter a regra da dependência para manter o isolamento, já que são responsáveis pelo real funcionamento da aplicação - são os códigos que queremos manter fechados para alteração, mas abertos para extensão.

![Diagrama Arquitetura para Spring Application](imgs/arch.png)

Nota-se que não existem setas que saem de uma Entity para apontar para qualquer outro componente e que as setas que saem do Use Case só apontam para Entities. Isso garante que o coração da aplicação não dependa da infraestrutura que o sustenta.

**Pacotes**  

Para a organização de pacotes, tem-se a seguinte proposta. A ideia é agrupar por domínio, onde todos os códigos relacionados um domínio estejam em um lugar centralizado.

![Diagrama Pacotes](imgs/package.png)

Lembre-se que não existe bala de prata. Em software tudo depende...

