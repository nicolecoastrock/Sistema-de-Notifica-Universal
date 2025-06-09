package com.snu;

import com.snu.notifier.model.NotificationPreference;
import com.snu.notifier.model.User;
import com.snu.notifier.observer.AdminSubscriber;
import com.snu.notifier.observer.NotificationEvent;
import com.snu.notifier.observer.NotificationPublisher;
import com.snu.notifier.observer.UserSubscriber;
import com.snu.notifier.service.NotificationService;

public class Main {
    public static void main(String[] args) {
        // Obter a instância do serviço de notificação (Singleton)
        NotificationService notificationService = NotificationService.getInstance();

        // Criar usuários com diferentes preferências
        NotificationPreference clientPref = new NotificationPreference("email", true, true, false);
        User clientUser = new User("1", "João", "joao@example.com", "11987654321", "CLIENT", clientPref);

        NotificationPreference adminPref = new NotificationPreference("sms", false, true, true);
        User adminUser = new User("2", "Maria (Admin)", "maria@admin.com", "11912345678", "ADMIN", adminPref);

        NotificationPreference partnerPref = new NotificationPreference("push", true, false, false);
        User partnerUser = new User("3", "Pedro (Partner)", "pedro@partner.com", "11999998888", "PARTNER", partnerPref);

        // Criar o publicador de notificações
        NotificationPublisher publisher = new NotificationPublisher();

        // Criar e adicionar assinantes (Observers)
        UserSubscriber clientSubscriber = new UserSubscriber(notificationService);
        publisher.addSubscriber(clientSubscriber);

        AdminSubscriber adminSubscriber = new AdminSubscriber(notificationService);
        publisher.addSubscriber(adminSubscriber);

        // ---- Cenários de Notificação ----

        System.out.println("\n--- Cenário 1: Notificação de Promoção ---");
        // Uma promoção é lançada, notifica os usuários que desejam recebê-la
        publisher.notifySubscribers(new NotificationEvent("Super promoção de verão!", clientUser, "PROMOTION"));
        publisher.notifySubscribers(new NotificationEvent("Nova oferta para parceiros!", partnerUser, "PROMOTION"));
        publisher.notifySubscribers(new NotificationEvent("Promoção de teste (admin)", adminUser, "PROMOTION")); // Admin não recebe promoções

        System.out.println("\n--- Cenário 2: Atualização de Conta ---");
        // Uma atualização na conta do cliente
        publisher.notifySubscribers(new NotificationEvent("Seus dados foram atualizados com sucesso.", clientUser, "ACCOUNT_UPDATE"));
        publisher.notifySubscribers(new NotificationEvent("Atualização de política de segurança.", adminUser, "ACCOUNT_UPDATE")); // Admin recebe

        System.out.println("\n--- Cenário 3: Alerta de Sistema ---");
        // Um alerta de sistema importante
        publisher.notifySubscribers(new NotificationEvent("Manutenção programada para amanhã às 03:00.", adminUser, "SYSTEM_ALERT"));
        publisher.notifySubscribers(new NotificationEvent("Problema no servidor, instabilidade esperada.", clientUser, "SYSTEM_ALERT")); // Cliente não recebe alertas de sistema diretamente do AdminSubscriber
    }
}