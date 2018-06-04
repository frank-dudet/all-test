package com.cn.frank.test.concurrent.threadpool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;


/**
 * Author: frank_du
 * Time : 2018/4/5 下午3:06
 */
public class FutureRelatedTask {

    private final ExecutorService executorService  = Executors.newSingleThreadExecutor();

    public void renderPage(String source) {
        final List<ImageInfo> imageInfos = scanForImageInfo(source);
        //耗时操作，用future封装，后续直接取结果
        Callable<List<ImageData>> task = new Callable<List<ImageData>>() {
            @Override
            public List<ImageData> call() throws Exception {
                List<ImageData> result = new ArrayList<ImageData>();
                for(ImageInfo imageInfo : imageInfos) {
                    result.add(imageInfo.downloadImageData(imageInfo));
                }
                Thread.currentThread().sleep(3000);
                return result;
            }
        };

        Future<List<ImageData>> future = executorService.submit(task);
        //其他的非耗时操作
        renderText(source);

        try {
            List<ImageData> imageDatas = future.get(2,TimeUnit.SECONDS);
            System.out.println("成功获取到结果");
            for(ImageData imageData : imageDatas) {
                renderImage(imageData);
            }
        } catch (InterruptedException e) {
            //重新设置线程的中断状态
            Thread.currentThread().interrupt();
            //由于不需要结果，因此取消任务
            future.cancel(true);
        } catch (ExecutionException e) {
            try {
                //任务执行过程中抛出了异常，重新抛出该异常，让上层感知
                throw new Exception(e.getCause());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } catch (TimeoutException e) {
            System.out.println("超时");
            future.cancel(true);
        }
    }


    //页面渲染的图片部分
    private void renderImage(ImageData imageData) {

    }

    //页面渲染的文字部分
    private void renderText(String source) {

    }

    //获取图片信息，然后下载图片
    private List<ImageInfo> scanForImageInfo(String source) {
        return Collections.emptyList();
    }

    static class ImageInfo {

        private String title;

        private String imageUrl;


        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        //下载图片，比较耗时的部分，因此需要future
        public ImageData downloadImageData(ImageInfo imageInfo) {
            return null;
        }
    }

    static class ImageData {

        private String title;

        private String image;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

    public static void main(String[] args) {
        new FutureRelatedTask().renderPage("");
    }
}
