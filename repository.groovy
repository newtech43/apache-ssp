#!/usr/bin/env groovy

def callS3Upload(mesg){
  stage("${mesg}") {
//    withAWS(credentials:'mobile-s3-user',region:'ap-south-1') {
//	s3Upload(acl:'PublicRead',bucket:'mybucket-ssp',cacheControl:'',excludePathPattern:'',file:"Build-${env.BUILD_NUMBER}",metadatas:[''],path:"${env.BRANCH_NAME}/Build-${env.BUILD_NUMBER}")
//    }
//withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', accessKeyVariable: 'AWS_ACCESS_KEY_ID', credentialsId: 'mobile-s3-user', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']]) {
//s3Upload(acl:'PublicRead',bucket:'mybucket-ssp',cacheControl:'',excludePathPattern:'',file:"Build-${env.BUILD_NUMBER}",metadatas:[''],path:"${env.BRANCH_NAME}/Build-${env.BUILD_NUMBER}")
//s3Upload consoleLogLevel: 'INFO', dontWaitForConcurrentBuildCompletion: false, entries: [[bucket: 'mybucket-ssp', excludedFile: '', flatten: false, gzipFiles: false, keepForever: false, managedArtifacts: false, noUploadOnFailure: false, selectedRegion: 'ap-south-1', showDirectlyInBrowser: false, sourceFile: '${WORKSPACE}/${env.BRANCH_NAME}/Build-${env.BUILD_NUMBER}', storageClass: 'STANDARD', uploadFromSlave: false, useServerSideEncryption: false]], pluginFailureResultConstraint: 'FAILURE', profileName: 'mobileapp', userMetadata: []

withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', accessKeyVariable: 'AWS_ACCESS_KEY_ID', credentialsId: 'mobile-s3-user', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']]) {
//s3Upload(acl:'PublicRead',bucket:'mybucket-ssp',cacheControl:'',excludePathPattern:'',file:"Build-${env.BUILD_NUMBER}",metadatas:[''],path:"${env.BRANCH_NAME}/Build-${env.BUILD_NUMBER}")
s3Upload consoleLogLevel: 'INFO', dontWaitForConcurrentBuildCompletion: false, entries: [[bucket: 'mybucket-ssp', excludedFile: '', flatten: false, gzipFiles: false, keepForever: false, managedArtifacts: false, noUploadOnFailure: false, selectedRegion: 'ap-south-1', showDirectlyInBrowser: false, file:"Build-${env.BUILD_NUMBER}", path:"${env.BRANCH_NAME}/Build-${env.BUILD_NUMBER}" , storageClass: 'STANDARD', uploadFromSlave: false, useServerSideEncryption: false]], pluginFailureResultConstraint: 'FAILURE', profileName: 'mobileapp', userMetadata: []
}


}
  }
}

def artifactory(){
  callS3Upload("Upload to S3")
}

return this;

