package ru.unlimmitted.mtwgeasy.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.unlimmitted.mtwgeasy.dto.Peer
import ru.unlimmitted.mtwgeasy.services.MikroTikService

@RestController
@RequestMapping("/api/v1")
class ApiController {

	@Autowired
	MikroTikService mikroTikService

	@GetMapping("/get-wg-peers")
	ResponseEntity<Object> getWgPeers() {
		return ResponseEntity.ok().body(mikroTikService.getPeers())
	}

	@GetMapping("/get-mikrotik-info")
	ResponseEntity<Object> getMikroTikInfo() {
		return ResponseEntity.ok().body(mikroTikService.getMtInfo())
	}

	@GetMapping("/get-mikrotik-settings")
	ResponseEntity<Object> getMikroTikSettings() {
		return ResponseEntity.ok().body(mikroTikService.settings)
	}

	@PostMapping("/create-new-peer")
	ResponseEntity<Object> createNewPeer(@RequestBody String peerName) {
		mikroTikService.createNewPeer(peerName)
		return ResponseEntity.ok().body(mikroTikService.getPeers())
	}

	@PostMapping("/change-routing-vpn")
	ResponseEntity<Object> changeRoutingVpn(@RequestBody Peer peer) {
		mikroTikService.changeRouting(peer)
		return ResponseEntity.ok().body(mikroTikService.getPeers())
	}

	@PostMapping("/remove-peer")
	ResponseEntity<Object> removePeer(@RequestBody Peer peer) {
		mikroTikService.removePeer(peer)
		return ResponseEntity.ok().body(mikroTikService.getPeers())
	}

}
