# geladeira-onipresente
Tratamento de Região Crítica com Threads

PROBLEMA PRINCIPAL

&emsp;A solução encontrada foi definir um limite máximo suportado de leite na classe "Geladeira". E, forncer métodos dentro dessa classe que permitem saber quando o limite de leite foi atingido.
Todas as instâncias da classe "Parente" recebem o mesmo abjeto "Geladeira" (pode se entender como se todos os parentes tivessem acesso à mesma geladeira da casa).
<br>&emsp;Nesse esquema, a instância da Geladeira, junto com seus atributos, representam a região crítica. E o processo de compra é o processo que permite alterar um dado dessa "região crítica".
<br>&emsp;Basicamente, pode se entender nesse exemplo que a geladeira é quase como uma variavel global, pois está acessível à multiplas instâncias em tempo de excução, distribuindo as mesmas informações entre essas mesmas classes quando elas precisam.
<br>&emsp;Para impedir que varios parentes comprem leite quando a geladeira está com sua capacidade atingida, cada um deles ira verificar a disponibilidade/necesidade de comprar leite através dos métodos booleanos "temLeite" e "atingiuLimiteDeLeite". Caso ambos os métodos retornem "true", o thread em questão  terá total libertade de incrementar a quantidade de leite presente no objeto geladeira.


SEGUNDO PROBLEMA ENCONTRADO

&emsp;Apenas por questão de lógica, o thread responsável por beber leite não deve "beber" caso a geladeira esteja vazia.
&emsp;Não ficou explícito no enunciado, porém, subentende-se que há também a necessidade de restringir a thread "BebeLeite" caso não haja leite disponível.
<br>&emsp;Assim foi feito neste projeto. Caso não haja leite, apenas uma mensagem informando que não há leite para beber será enviada e nenhuma alteração no objeto geladeira será feita.
