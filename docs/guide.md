# Guia Prático

## como realizar o deploy da aplicação usando docker

## como realizar o deploy da aplicação manualmente

## como gerar a documentação online com mkdocs

1. crie um ambiente virtual com o comando python na raiz do projeto onde está
o arquivo mkdocs.yml e o requirements.txt

```bash
python3 -m venv venv
```

2. ative o ambiente virtual com o seguinte comando, ai vai depender se seu SO, o meu é
um linux Mint por exemplo:

```bash
source venv/bin/activate
```

3. abrirá um terminal com a descrição que aquela linha de comando está no ambiente virtual(venv)
apartir disso instale as dependencias se ainda não tiver

```bash
pip install -r requirements.txt
```

4. agora você pode executar o servidor mkdocs ou até mesmo gerar seu site

```bash
mkdocs serve
```

