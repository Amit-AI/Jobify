import JobCard from "../components/JobCard";

export default function Jobs() {
    return (
        <div class="container my-12 mx-auto px-4 md:px-12 flex flex-wrap sm:flex-col sm:items-center">
           <JobCard/>
           <JobCard/>
           <JobCard/>
           <JobCard/>
        </div>
    );
}
