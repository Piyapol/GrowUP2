package com.example.xeus_labmacbook.growup;

import com.google.firebase.messaging.FirebaseMessagingService;

/**
 * Created by DuckWalkZ on 14/4/2560.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
//    /**
//     * Called when message is received.
//     *
//     * @param remoteMessage Object representing the message received from Firebase Cloud Messaging.
//     */
//    @Override
//    public void onMessageReceived(RemoteMessage remoteMessage) {
//        super.onMessageReceived(remoteMessage);
//        // TODO(developer): Handle FCM messages here.
//        // If the application is in the foreground handle both data and notification messages here.
//        // Also if you intend on generating your own notifications as a result of a received FCM
//        // message, here is where that should be initiated. See sendNotification method below.
//        RemoteMessage.Notification notification = remoteMessage.getNotification();
//        Map<String, String> data = remoteMessage.getData();
//
//        sendNotification(notification, data);
//    }
//
//    /**
//     * Create and show a custom notification containing the received FCM message.
//     *
//     * @param notification FCM notification payload received.
//     * @param data FCM data payload received.
//     */
//    private void sendNotification(RemoteMessage.Notification notification, Map<String, String> data) {
//        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
//
//        Intent intent = new Intent(this, MainActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
//
//        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
//                .setContentTitle(notification.getTitle())
//                .setContentText(notification.getBody())
//                .setAutoCancel(true)
//                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
//                .setContentIntent(pendingIntent)
//                .setContentInfo(notification.getTitle())
//                .setLargeIcon(icon)
//                .setColor(Color.RED)
//                .setSmallIcon(R.mipmap.ic_launcher);
//
//        try {
//            String picture_url = data.get("picture_url");
//            if (picture_url != null && !"".equals(picture_url)) {
//                URL url = new URL(picture_url);
//                Bitmap bigPicture = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//                notificationBuilder.setStyle(
//                        new NotificationCompat.BigPictureStyle().bigPicture(bigPicture).setSummaryText(notification.getBody())
//                );
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        notificationBuilder.setDefaults(Notification.DEFAULT_VIBRATE);
//        notificationBuilder.setLights(Color.YELLOW, 1000, 300);
//
//        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        notificationManager.notify(0, notificationBuilder.build());
//    }
}