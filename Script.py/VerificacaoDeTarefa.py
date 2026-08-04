from datetime import datetime
import pywhatkit
import requests

URL_API = 'http://localhost:8080/tarefas/busca/PENDETE'
MEU_WHATSAPP = '+5588999931310'

def verificar_tarefas_pendentes():
    print('Conectando à API Java')

    try:
        resposta = requests.get(URL_API)

        if resposta.status_code == 200:
            tarefas = resposta.json()

            if not tarefas:
                print("Nenhuma tarefa pendente no momento. Bom trabalho")
                return

            mensagem = (f"\n--- ALERTA: Você tem {len(tarefas)} tarefas(s) pendente(s) ---")

            for tarefa in tarefas:
                titulo = tarefa['titulo']
                descricao = tarefa['descricao']
                mensagem += f'\n-> Tarefa: {titulo} - {descricao}'

            print("Enviando mensagem para o WhatsApp")

            pywhatkit.sendwhatmsg_instantly(
                phone_no=MEU_WHATSAPP, message=mensagem, wait_time=15, tab_close=True
            )

    except requests.exceptions.ConnectionError:
        print('Erro de conexão: Não foi possivel localizar a API!')

if __name__ == '__main__':
    verificar_tarefas_pendentes()



    