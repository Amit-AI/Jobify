import {Routes, Route} from 'react-router-dom';
import Contact from '../pages/Contact';
import Dashboard from '../pages/Dashboard';
import Jobs from '../pages/Jobs';

export default function Router() {
  return (
    <div>
        <Routes>
            <Route path='/' element={<Dashboard/>}/>
            <Route path='/jobs' element={<Jobs/>}/>
            <Route path='/contact' element={<Contact/>}/>
        </Routes>
    </div>
  )
}
