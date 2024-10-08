package ru.unlimmitted.mtwgeasy.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.CrossOrigin
import ru.unlimmitted.mtwgeasy.dto.MtInfo
import ru.unlimmitted.mtwgeasy.dto.Peer

@Service
@CrossOrigin
class WebSocketService {
	@Autowired
	private SimpMessagingTemplate simpMessaging

	void sendPeers(List<Peer> message) {
		simpMessaging.convertAndSend("/topic/peers/", message)
	}

	void sendInterfaces(MtInfo message) {
		simpMessaging.convertAndSend("/topic/interface/", message)
	}
}
